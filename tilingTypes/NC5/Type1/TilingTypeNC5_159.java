package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_159
   extends TilingType
{
   public TilingTypeNC5_159(){
      super( "NC5-159", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,4, 0,4,0, 0},
            {1, 3,4, 0,1,0, 0},
            {1, 0,4, 2,4,0, 0},

      };
      info = "c=d\nb=c+d+e\nB=90\nC=90\nD=270\n(A=45)\n(E=45)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.0;
      double w = lnt * getParam(paramValues,0)/200;
      double h = lnt - w;
     
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, h+w,  0);
      baseTile.setPoint(2, h+w,  w);
      baseTile.setPoint(3,   h,  w);
      baseTile.setPoint(4,   h,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(3)-tiles[1].getX(1);
      offsets[3] = tiles[3].getY(3)-tiles[1].getY(1);
   }
}
