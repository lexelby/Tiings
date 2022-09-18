package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_154
   extends TilingType
{
   public TilingTypeNC5_154(){
      super( "NC5-154", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Aspect"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,4, 0,4,0, 0},
            {1, 3,4, 0,1,2, 1},
            {1, 1,0, 2,0,1, 1},
      };
      info = "b=2d\nc=e\nB=D\nC+D=180\nA+C=360\n(B+D+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lnt = .75;
      double h = lnt * getParam(paramValues, 0)/100; 
      double w = (lnt - h)/2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, 4*w, 0);
      baseTile.setPoint(2, 5*w, h);
      baseTile.setPoint(3, 3*w, h);
      baseTile.setPoint(4, 2*w, 2*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(1)-tiles[3].getX(3);
      offsets[3] = tiles[1].getY(1)-tiles[3].getY(3);
   }
}
