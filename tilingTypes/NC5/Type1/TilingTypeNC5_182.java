package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_182
   extends TilingType
{
   public TilingTypeNC5_182(){
      super( "NC5-182", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{ 90,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,3,4, 1},
            {1, 4,1, 1,1,4, 1},
            {0, 3,4, 2,4,0, 0},
      };
      info = "c=e\na=2c\nA+C=180\nC+D=360\n(A+B+E=180)\n(A=B)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 0.4;
      double lnb = getParam(paramValues,1)/100;
      double lnce = 1 - lnb;

      double b = getParam(paramValues,0);
      double dx = lnce * Math.cos(b * DEG2RAD);
      double dy = lnce * Math.sin(b * DEG2RAD);
      lnb += 4*dx;

      // scale
      double f = Math.sqrt( lnt / (dy*lnb) );
      lnb *= f;
      dx *=f;
      dy *=f;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lnb, 0);
      baseTile.setPoint(2, lnb - dx, dy);
      baseTile.setPoint(3, 3*dx, dy);
      baseTile.setPoint(4, 2*dx, 2*dy);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(1);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(1);
      offsets[2] = tiles[0].getX(1)-tiles[0].getX(4);
      offsets[3] = tiles[0].getY(1)-tiles[0].getY(4);
   }
}
