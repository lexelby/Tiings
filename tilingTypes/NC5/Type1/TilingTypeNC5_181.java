package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_181
   extends TilingType
{
   public TilingTypeNC5_181(){
      super( "NC5-181", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 50, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,1, 0,1,4, 0},
            {1, 4,0, 0,0,1, 1},
            {1, 1,2, 2,2,1, 1},
      };
      info = "a=b\nc=e\nB=D\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 0.35;

      double b = getParam(paramValues,0);
      double h = Math.cos(b/2 * DEG2RAD);
      double w = Math.sin(b/2 * DEG2RAD);
      double f = lnt / (h*w);
      h *= f;
      w *= f;
      
      double lnab = Math.sqrt(w*w+h*h);
      double lnd = lnab * getParam(paramValues,1)/100;
      
      double x4 = lnab * Math.cos(b * DEG2RAD);
      double y4 = lnab * Math.sin(b * DEG2RAD);
      double x2 = (x4+lnab-lnd)/2;
      double y2 = y4/2;
      
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lnab, 0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x2+lnd, y2);
      baseTile.setPoint(4, x4,y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(3)-tiles[2].getX(4);
      offsets[1] = tiles[3].getY(3)-tiles[2].getY(4);
      offsets[2] = tiles[1].getX(0)-tiles[3].getX(4);
      offsets[3] = tiles[1].getY(0)-tiles[3].getY(4);
   }
}
