package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_35
   extends TilingType
{
   public TilingTypeNC5_35(){
      super( "NC5-35", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,3,4, 0},
            {1, 3,0, 1,0,3, 0},
            {0, 3,4, 2,0,4, 0},
      };
      info = "a=2b=2d\ne=a+c\nA=60\nB=240\nC=120\nD=60\n(E=60)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = .75;
      double ln1 = ln2*paramValues[0]/100.;
      double h = ln1*Math.sqrt(3)/2;

      double x4 = -ln1;
      double y4 = 2*h;
      double x3 = ln2;
      double y3 = 2*h;
      double x1 = ln1/2;
      double y1 = h;
      double x2 = ln2-ln1/2;
      double y2 = h;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[0].getY(0);
   }
}
